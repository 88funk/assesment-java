package za.co.itq.assesment.web.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.itq.assesment.domain.UserRequestDto;
import za.co.itq.assesment.domain.UserResponseDto;
import za.co.itq.assesment.service.PalidromeService;
import za.co.itq.assesment.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "palidrome")
public class PalindromicController {

    @Autowired
    private PalidromeService palidromeService;

    @ApiOperation("controller that will return the Longest Palindromic Substring.")
    @RequestMapping(value = "/longest/{input}", method = POST)
    public String getLongestPalindromicSubString(@PathVariable String input) {
        return palidromeService.generateLongestPalidromeString(input);
    }
    

}
