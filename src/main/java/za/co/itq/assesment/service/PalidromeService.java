package za.co.itq.assesment.service;

import za.co.itq.assesment.domain.UserRequestDto;
import za.co.itq.assesment.domain.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface PalidromeService {

    String generateLongestPalidromeString(String input);


}
