package life.achao.community.provider;

import com.alibaba.fastjson.JSON;
import life.achao.community.dto.AccessTokenDTO;
import life.achao.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @PackageName: life.achao.community.provider
 * @ClassName: GithubProvider
 * @Description:
 * @Author: Jonathan
 * @Date: 2019/12/14 15:10
 */
@Component //仅仅把当前的类初始化到spring的上下文
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                    String string = response.body().string();
                    //access_token=8c823198c25971c5c4eed68bd3247aaeaee7e0c2&scope=user&token_type=bearer
                String token = string.split("&")[0].split("=")[1];
//                System.out.println(string);
                    return token;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+ accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
