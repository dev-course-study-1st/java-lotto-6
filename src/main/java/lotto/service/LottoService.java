package lotto.service;

import lotto.model.*;
import lotto.utils.NumberGenerator;
import lotto.utils.constant.LottoGameNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public Player purchaseLotto(int purchaseMoney) {
        int lottoCount = purchaseMoney / LottoGameNumber.LOTTO_GAME_PRICE.getNumber();
        Budget budget = new Budget(purchaseMoney);
        List<Lotto> lottos = generateLottos(lottoCount);
        Lottos lottosList = new Lottos(lottos);
        return new Player(lottosList, budget);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(NumberGenerator.generateLottoNumbers()));
        }
        return lottos;
    }

    public LottoResult calculateLottoResult(Player player, WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : player.getLottosList()) {
            LottoRank lottoRank = winningLotto.matchLotto(lotto);
            lottoResult.updateLottoResult(lottoRank);
        }
        return lottoResult;
    }
}
