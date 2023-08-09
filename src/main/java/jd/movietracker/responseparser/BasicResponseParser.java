package jd.movietracker.responseparser;

import java.util.List;

public class BasicResponseParser implements ResponseParser {
    @Override
    public List<String> parseRequestWithCheckboxesWithoutValue(String request) {
        String expectedResponse = "on";
        String concatenationCharacterString = "&";

        request = request.replaceAll("=" + expectedResponse, "");
        String[] selectedCheckboxesValues = request.split(concatenationCharacterString);

        return List.of(selectedCheckboxesValues);
    }
}
