package life.achao.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @PackageName: life.achao.community.controller
 * @ClassName: PublishController
 * @Description:
 * @Author: Jonathan
 * @Date: 2019/12/15 20:12
 */
@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
}
