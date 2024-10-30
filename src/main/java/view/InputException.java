package view;

public class InputException {

    public static void validateHeightSize(int height){
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    public static void validateViewerNameNotBlank(String viewerName){
        if (viewerName.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }
}
