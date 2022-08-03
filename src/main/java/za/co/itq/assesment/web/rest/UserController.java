package za.co.itq.assesment.web.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import za.co.itq.assesment.domain.UserRequestDto;
import za.co.itq.assesment.domain.UserResponseDto;
import za.co.itq.assesment.service.UserService;


import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("This endpoint will add a new user into the H2 database")
    @RequestMapping(value = "/add", method = POST, consumes = { APPLICATION_JSON_VALUE})
    public UserResponseDto addUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        System.out.println("new user added, UUID " + userResponseDto.getId());
        return userResponseDto;
    }

    @ApiOperation("This endpoint will retrieve and display the user in the H2 database by IdNumber, and convert to its values to uppercase")
    @RequestMapping(value = "/retrieve/{uuid}", method = GET, produces = {APPLICATION_JSON_VALUE})
    public UserResponseDto retrieveUser(@PathVariable("uuid") String uuid) {
        UserResponseDto userResponseDto = userService.retrieveUserById(UUID.fromString(uuid));
        if(userResponseDto != null){
            System.out.println("user found with UUID " + userResponseDto.getId());
        } else {
            System.out.println("user NOT found with UUID " + uuid);
        }
        return userResponseDto;
    }

    @ApiOperation("This endpoint will retrieve all users in the H2 database")
    @RequestMapping(value = "/all", method = GET, produces = {APPLICATION_JSON_VALUE})
    public List<UserResponseDto> retrieveAllUser() {
        List<UserResponseDto> userResponseDto = userService.findAll();
        return userResponseDto;
    }

}
