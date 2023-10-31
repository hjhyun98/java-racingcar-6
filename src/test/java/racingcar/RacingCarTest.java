package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest extends NsTest {

    Computer computer = new Computer();
    @Test
    void 이름_공백_무효_처리() {
        String testName = "   pobi";
        assertThat(computer.removeBlank(testName)).isEqualTo("pobi");

    }

    @Test
    void 자동차가_한_대_일_경우(){
        assertSimpleTest(() ->{
            run("pobi","1");
            assertThat(output()).contains("pobi : ", "최종 우승자 : pobi");
            }
        );
    }

    @Test
    void 시도_회수_입력값_타입에_대한_예외_처리(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_입력값이_0일_경우_예외_처리(){
        assertThatThrownBy(() -> runException("pobi,woni","0")).isInstanceOf(IllegalArgumentException.class);

    }

//    @Test
//    void 최종_우승자가_여러_명일_경우(){
//        assertSimpleTest(() ->
//                run("pobi,woni,jini", "3")
//
//                assertThat());
// }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
