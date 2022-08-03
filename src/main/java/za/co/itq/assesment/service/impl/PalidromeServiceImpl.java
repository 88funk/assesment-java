package za.co.itq.assesment.service.impl;


import org.springframework.stereotype.Service;
import za.co.itq.assesment.service.PalidromeService;


@Service
public class PalidromeServiceImpl implements PalidromeService {

    private String displaySubString(String str, int low, int high)
    {
        StringBuilder s = new StringBuilder();
        for (int i = low; i <= high; ++i)
            s.append(str.charAt(i));

        return s.toString();
    }

    @Override
    public String generateLongestPalidromeString(String str) {
        int n = str.length();

        int maxLength = 1, start = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k))
                        flag = 0;

                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        return displaySubString(str, start, start + maxLength - 1);
    }
}
