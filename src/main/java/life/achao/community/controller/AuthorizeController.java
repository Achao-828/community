package life.achao.community.controller;

import life.achao.community.dto.AccessTokenDTO;
import life.achao.community.dto.GithubUser;
import life.achao.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @PackageName: life.achao.community.controller
 * @ClassName: AuthorizeController
 * @Description:
 * @Author: Jonathan
 * @Date: 2019/12/14 15:04
 */
@Controller //controller是把当前的类作为路由API的一个承载者
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider; //拿到Github返回信息

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect_uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){
        final AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
//        System.out.println(user.getName());
        if (user != null){
            // 登录成功,写cookie和session
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        }else {
            // 登录失败,重新登录
            return "redirect:/";
        }
    }
}
