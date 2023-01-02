package kr.codesquad.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto());
        }

        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = LottoNumberGenerator.generate();
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

}
