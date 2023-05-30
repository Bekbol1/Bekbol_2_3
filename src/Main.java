public class Main {
    public static void main(String[] args)  {
        BankAccount  cardBalance = new BankAccount();
        cardBalance.deposit(20000);
        double withdrawalAmount = 6000;

        while (true) {
            try {
                cardBalance.withDraw(6000);
                System.out.println("Снято: " + withdrawalAmount + " сом");
            } catch (LimitException e) {
                try {
                    cardBalance.withDraw((int) e.getRemainingAmount());
                } catch (LimitException exception) {
                    exception.printStackTrace();
                }
            }
            System.out.println(cardBalance.getAmount());
            if (cardBalance.getAmount() == 0) {
                break;
            }
        }

        System.out.println("Баланс вашей карты: " + cardBalance.getAmount() +  " сом");
    }
}