package kr.codesquad.controller;

import kr.codesquad.model.Lotto;
import kr.codesquad.model.LottoMachine;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public void start() {
        OutputView.printMoneyReadMessage();
        int money = InputView.readMoney();

        int lottoCount = money / 1000;
        OutputView.printLottoCount(lottoCount);

        List<Lotto> lottos = lottoMachine.createLottos(lottoCount);

        OutputView.printLottos(lottos);

        OutputView.printWinningLottoReadMessage();
        Lotto winningLotto = InputView.readWinningLotto();

        Map<Integer, Integer> result = caculateResult(lottos, winningLotto);
    }

    private Map<Integer, Integer> caculateResult(List<Lotto> lottos, Lotto winningLotto) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 3; i <= 6; i++){
            result.put(i, 0);
        }

        lottos.forEach(lotto -> {
                int sameCount = lotto.compare(winningLotto);
                if (result.containsKey(sameCount)) {
                    result.put(sameCount, result.get(sameCount)+1);
                }
        });

        return result;
    }
}
