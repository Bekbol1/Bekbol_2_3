public class Main {
    public static void main(String[] args) throws LimitException {
        BankAccount  cardBalance = new BankAccount();
        cardBalance.deposit(20000);
        double withdrawalAmount = 6000;
        while (true) {
            try {
                cardBalance.withDraw(withdrawalAmount);
                System.out.println("Снято: " + withdrawalAmount + " сом");
            } catch (LimitException e) {
                System.out.println("Недостаточно для снятия такой суммы. Остаток на карте: " + e.getRemainingAmount());
                withdrawalAmount = e.getRemainingAmount();
                cardBalance.withDraw(withdrawalAmount);
                System.out.println("Снято: " + withdrawalAmount + " сом");
                break;
            }
        }

        System.out.println("Баланс вашей карты: " + cardBalance.getAmount() +  " сом");
    }
}