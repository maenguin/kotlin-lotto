package lotto

import lotto.domain.IssuedLottoMatchResult
import lotto.domain.IssuedLottos
import lotto.domain.Lotto
import lotto.domain.LottoSeller
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val lottoSeller = LottoSeller()

    val seedMoney: Int = inputView.inputSeedMoney()
    val issuedLottos: IssuedLottos = lottoSeller.sell(seedMoney)
    resultView.outputIssuedLottos(issuedLottos)

    val winningNumbers: Set<Int> = inputView.inputWinningNumbers()
    val issuedLottoMatchResult: IssuedLottoMatchResult = issuedLottos.check(Lotto(winningNumbers))
    resultView.outputLottoMatchStat(issuedLottoMatchResult.matchStat)

    val earningsRate: Double = issuedLottoMatchResult.calculateEarningsRate(seedMoney)
    resultView.outputEarningsRate(earningsRate)
}
