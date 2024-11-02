# 기능 구현

사다리의 연결은 Boolean을 통해 표현
+ true면 "-----" 연결되었다는 뜻
+ false면 연결되지 않았다는 뜻

## **controller**
+ LadderController

## **domain**
+ Ladder
  * List&lt;Line&gt; 사다리 전체를 표현하는 객체
+ LadderGame
  * 사다리 게임 실행과 관련된 메서드를 담은 클래스
+ LadderGenerator
  * 사다리 생성과 관련된 메서드를 담은 클래스
+ Line
  * List&lt;Boolean&gt; 사다리 한 줄을 표현하는 객체
+ PlayerName
  * 플레이어 이름을 원시값 포장한 객체
+ Player
  * 플레이어 객체
+ Players
  * 플레이어 리스트 일급 컬렉션
+ Positon
  * 플레이어 위치를 원시값 포장한 객체
+ ResultTypes
  * 결과 리스트 일급 컬렉션

## **View**
+ InputException
+ InputView
+ OutputView
