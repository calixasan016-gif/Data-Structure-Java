public static void main(String[] args) {
    {

        SavingsAccount s = new SavingsAccount("SAV-1", 200);
        CurrentAccount c = new CurrentAccount("CUR-1", 200);
        StudentAccount t = new StudentAccount("STU-1", 200);

        System.out.println("Each account has 200. Each runs withdraw(300):");

        s.withdraw(300);
        s.show();

        c.withdraw(300);
        c.show();

        t.withdraw(300);
        t.show();

        System.out.println("Student tries withdraw(80):");

        t.withdraw(80);
        t.show();
    }
}
