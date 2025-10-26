package problems.push

class Bank(private val balances: LongArray) {

  private val totalAccounts: Int = balances.size

  private fun isValidAccount(accountNumber: Int): Boolean {
    return accountNumber in 1..totalAccounts
  }

  fun transfer(accountFrom: Int, accountTo: Int, money: Long): Boolean {
    if (!isValidAccount(accountFrom) || !isValidAccount(accountTo)) {
      return false
    }
    val fromIndex = accountFrom - 1
    val toIndex = accountTo - 1

    if (balances[fromIndex] < money) {
      return false
    }

    balances[fromIndex] -= money
    balances[toIndex] += money
    return true
  }

  fun deposit(account: Int, money: Long): Boolean {
    if (!isValidAccount(account)) {
      return false
    }
    val index = account - 1
    balances[index] += money
    return true
  }

  fun withdraw(account: Int, money: Long): Boolean {
    if (!isValidAccount(account)) {
      return false
    }
    val index = account - 1
    if (balances[index] < money) {
      return false
    }
    balances[index] -= money
    return true
  }
}
