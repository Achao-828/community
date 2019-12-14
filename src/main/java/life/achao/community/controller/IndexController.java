package life.achao.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @PackageName: life.achao.community.controller
 * @ClassName: HelloController
 * @Description:
 * @Author: Jonathan
 * @Date: 2019/12/13 20:51
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {return "index"; }
}
