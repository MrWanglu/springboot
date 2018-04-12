package cn.sboot.config;

import cn.sboot.pojo.User;
import cn.sboot.repository.SbootRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/visit")
public class SbootController {

    @Autowired
    private SbootRepository sbootRepository;

    /**
     * * 根据用户的ID查询用户的信息
     */
    @RequestMapping(value = "byId", method = RequestMethod.POST)
    @ApiOperation(value = "通过用户ID来查询用户的相关信息", notes = "最初接口模型")
    public String getUserById() {
        User user = sbootRepository.findByUserId(1001);
        System.out.println("根据用户的ID查询出来的用户信息：" + user.getUserId() + "\t"
                + user.getUserName() + "\t"
                + user.getUserSex() + "\t"
                + user.getUserPwd()
        );
        return "";
    }

    /**
     * 根据用户的姓名查询用户的信息
     */
    @RequestMapping(value = "byName", method = RequestMethod.POST)
    @ApiOperation(value = "根据用户的姓名在查找用户的相关信息", notes = "最初接口模型")
    public String getUserByName() {
        User byNameUser = sbootRepository.findByUserName("王丽");
        System.out.println("根据用户的姓名查询出来用户的信息：" + byNameUser.getUserId() + "\t"
                + byNameUser.getUserName() + "\t"
                + byNameUser.getUserSex() + "\t"
                + byNameUser.getUserPwd()
        );
        return "";
    }

    /**
     * 查询全部用户的信息
     */
    @RequestMapping(value = "getAll", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有用户的信息", notes = "最初接口模型")
    public String getAll() {
        List<User> users = sbootRepository.findAll();
        for (User user1 : users) {
            System.out.println("查询出全部用户的信息：" + user1.getUserId() + "\t"
                    + user1.getUserName() + "\t"
                    + user1.getUserPwd() + "\t"
                    + user1.getUserSex());
        }
        return "";
    }
}