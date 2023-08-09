package jd.movietracker.responseparser;

import java.util.List;

public interface ResponseParser {
    List<String> parseRequestWithCheckboxesWithoutValue(String request);
}
