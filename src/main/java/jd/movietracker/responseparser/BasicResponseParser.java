package jd.movietracker.responseparser;

import java.util.List;

public class BasicResponseParser implements ResponseParser {
    @Override
    public List<String> parseRequestWithCheckboxesWithoutValue(String request) {
        String expectedResponse = "on";
        String concatenationCharacter = "&";

        request = request.replaceAll("=" + expectedResponse, "");
        String[] selectedCheckboxesValues = request.split(concatenationCharacter);

        return List.of(selectedCheckboxesValues);
    }
}
