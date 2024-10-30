package domain;

import java.util.List;

public class ResultTypes {

    private final List<String> resultTypes;

    public ResultTypes(List<String> resultTypes, int width) {
        validate(resultTypes, width);
        this.resultTypes = resultTypes;
    }

    private void validate(List<String> resultTypes, int width) {
        resultTypes.forEach(this::validateNotBlank);
        validateSize(resultTypes, width);
    }

    private void validateNotBlank(String resultType) {
        if (resultType.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 공백일 수 없습니다.");
        }
    }

    private void validateSize(List<String> resultTypes, int width) {
        if (resultTypes.size() != width) {
            throw new IllegalArgumentException("실행 결과는 사다리의 개수와 일치해야 합니다.");
        }
    }

    public List<String> getResultTypes() {
        return resultTypes;
    }
}
