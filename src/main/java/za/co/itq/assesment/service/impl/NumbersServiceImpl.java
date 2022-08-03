package za.co.itq.assesment.service.impl;

import org.springframework.stereotype.Service;
import za.co.itq.assesment.domain.NumbersDto;
import za.co.itq.assesment.service.NumbersService;
import za.co.itq.assesment.service.PalidromeService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class NumbersServiceImpl implements NumbersService {

    @Override
    public int[] indexesOfTwo(NumbersDto numbersDto) {
        List<Integer> s = Arrays.asList(numbersDto.getCommaSeparatedInput().split(","))
                .stream()
                .map(number -> Integer.parseInt(number) )
                .collect(Collectors.toList());

        Map<Integer, Integer> numberIndexMap = new HashMap<>();
        for (int i = 0; i < s.size(); i++) {
            int x = numbersDto.getTarget() - s.get(i);
            if(numberIndexMap.containsKey(x)){
                return new int[] { numberIndexMap.get(x), i };
            } else {
                numberIndexMap.put(s.get(i), i);
            }
        }
        return new int[] {};
    }
}
