class polynomial {
    int coef;
    int exp;
    polynomial next;

    polynomial(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }
}

class polynomialLL {
    polynomial head = null;

    public void insertEquation(int coef, int exp) {
        polynomial newnode = new polynomial(coef, exp);
        if (head == null || head.exp < exp) {
            newnode.next = head;
            head = newnode;
            return;
        }
        polynomial temp = head;
        while (temp.next != null && temp.next.exp >= exp) {
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void printEquation() {
        if (head == null) {
            System.out.print("0");
            return;
        }
        polynomial temp = head;
        while (temp != null) {
            if (temp.coef != 0) {
                if (temp != head) {
                    if (temp.coef > 0) {
                        System.out.print("+");
                    } else if (temp.coef < 0) {
                        System.out.print("-");
                    }
                }
            }

            if (temp.exp == 0)
                System.out.print(temp.coef);
            else if (temp.coef == 1)
                System.out.print("x");
            else
                System.out.print(temp.coef + "x^" + temp.exp);
            temp = temp.next;
        }
    }

    public polynomialLL addPolynomials(polynomialLL poly1, polynomialLL poly2) {
        polynomialLL result = new polynomialLL();
        polynomial p1 = poly1.head;
        polynomial p2 = poly2.head;

        while (p1 != null && p2 != null) {
            if (p1.exp == p2.exp) {
                int sum = p1.coef + p2.coef;
                if (sum != 0)
                    result.insertEquation(sum, p1.exp);
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.exp > p2.exp) {
                result.insertEquation(p1.coef, p1.exp);
                p1 = p1.next;
            } else {
                result.insertEquation(p2.coef, p2.exp);
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            result.insertEquation(p1.coef, p1.exp);
            p1 = p1.next;
        }
        while (p2 != null) {
            result.insertEquation(p2.coef, p2.exp);
            p2 = p2.next;
        }
        return result;
    }

    public polynomialLL subPolynomials(polynomialLL poly1, polynomialLL poly2) {
        polynomialLL result = new polynomialLL();
        polynomial p1 = poly1.head;
        polynomial p2 = poly2.head;
        while (p1 != null && p2 != null) {
            if (p1.exp == p2.exp) {
                int diff = p1.coef - p2.coef;
                if (diff != 0)
                    result.insertEquation(diff, p1.exp);
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.exp > p2.exp) {
                result.insertEquation(p1.coef, p1.exp);
                p1 = p1.next;
            } else {
                result.insertEquation(p2.coef, p2.exp);
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            result.insertEquation(p1.coef, p1.exp);
            p1 = p1.next;
        }

        while (p2 != null) {
            result.insertEquation(p2.coef, p2.exp);
            p2 = p2.next;
        }

        return result;
    }
}


public class LinkedListForPolynomials {
    public static void main(String[] args) {
        polynomialLL p1 = new polynomialLL();
        p1.insertEquation(2, 2);
        p1.insertEquation(5, 1);
        p1.insertEquation(7, 0);
        p1.printEquation();

        System.out.println();

        polynomialLL p2 = new polynomialLL();
        p2.insertEquation(3, 2);
        p2.printEquation();

        System.out.println();
        polynomialLL p3 = p1.addPolynomials(p1, p2);
        p3.printEquation();

        System.out.println();
        polynomialLL p4 = p1.subPolynomials(p1, p2);
        p4.printEquation();
    }
}





