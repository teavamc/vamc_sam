package com.teavamc.vamcsam.web;

import com.teavamc.vamcsam.web.utils.SymmetricAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.teavamc.vamcsam.api.local.UserService;
import com.teavamc.vamcsam.api.entity.UserModel;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
@RestController
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/username")
//    public String getUserName(@RequestParam("id") Long id) {
//        return userService.getUserName(id);
//    }
//
//    @RequestMapping("/add")
//    @ResponseBody
//    public UserModel addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
//        UserModel user = new UserModel();
//        user.setName(name);
//        user.setAge(age);
//        return userService.addUser(user);
//    }

    @PostMapping("/error")
    public void throwError(@RequestBody String string) throws Exception {
        throw new Exception();
    }

    @PostMapping(path = "ins/POCCallout/POCqueryCallData.pub")
    String test(@RequestBody String request){
        return SymmetricAES.AESDncode(request);
    }
}
