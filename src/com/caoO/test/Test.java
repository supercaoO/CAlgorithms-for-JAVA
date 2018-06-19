package com.caoO.test;

import com.caoO.algorithms.*;
import com.caoO.expression.ArithmeticalExpression;
import com.caoO.std.StdDraw;
import com.caoO.std.StdOut;
import com.caoO.std.StdRandom;
import com.caoO.structrue.collection.*;
import com.caoO.utils.compress.Rar;
import com.caoO.utils.compress.SevenZ;
import com.caoO.utils.compress.Zip;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
    @org.junit.Test
    public void test01() {
        int i = CMath.abs(-1);
        System.out.println(i);
    }

    @org.junit.Test
    public void test02() {
        double d = CMath.sqrt(0.01);
        System.out.println(d);
    }

    @org.junit.Test
    public void test03() {
        double d = java.lang.Math.pow(10, 15);
        System.out.println(d);
    }

    @org.junit.Test
    public void test04() {
        double d = CMath.hypotenuse(3, 4);
        System.out.println(d);
    }

    @org.junit.Test
    public void test05() {
        String[] str = { null, "s", null, "b", "c" };
        String s = CArrays.max(str);
        System.out.println(s);
    }

    @org.junit.Test
    public void test06() {
        double[] str = { 2, Double.NaN, 1 };
        double d = CArrays.max(str);
        System.out.println(d);
    }

    @org.junit.Test
    public void test07() {
        int[][] arr1 = { {1, 2, 3}, {1, 2, 3} };
        int[][] arr2 = { {1, 2}, {1, 2}, {1, 2} };
        int[][] arr = CMatrix.mult(arr1, arr2);
        COut.print2DArray(arr);
    }

    @org.junit.Test
    public void test08() {
        double[][] arr1 = { {1, 2, 3}, {1, 2, 3} };
        double[] arr2 = { 1, 2, 3 };
        double[] arr = CMatrix.mult(arr1, arr2);
        COut.printArray(arr);
    }

    @org.junit.Test
    public void test09() {
        double[][] arr1 = { {1, 2}, {1, 2}, {1, 2} };
        double[] arr2 = { 1, 2, 3 };
        double[] arr = CMatrix.mult(arr2, arr1);
        COut.printArray(arr);
    }

    @org.junit.Test
    public void test10() {
        int[][] arr1 = { {1, 2}, {1, 2}, {1, 2} };
        int[][] arr = CMatrix.transpose(arr1);
        COut.print2DArray(arr);
    }

    @org.junit.Test
    public void test11() {
        System.out.println((364 + 365 * 3) % 7);
    }

    @org.junit.Test
    public void test12() {
        System.out.println(742 % 7);
    }

    @org.junit.Test
    public void test13() {
        System.out.println(((364 + 365 * 3) * 4 + 364 + 365 + 1) % 7);
    }

    @org.junit.Test
    public void test14() {
        System.out.println(((366 + 365 * 3) * 4 + 366 + 365 + 1) % 7);
    }

    @org.junit.Test
    public void test5() {
        System.out.println(-11 % 7);
    }

    @org.junit.Test
    public void test6() {
        SevenZ.compress("B","E:/A.doc","E:/");
        Zip.compress("C", "E:/B.7z", "E:/");
        Rar.compress("D", "E:/B.7z", "E:/");
        SevenZ.compress("E", "E:/B.7z", "E:/");
    }

    @org.junit.Test
    public void evaluateOfArithmeticalExpression() {
        double result01 = ArithmeticalExpression.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
        StdOut.println(result01);
        double result02 = ArithmeticalExpression.evaluate("( ( 1 + sqrt ( 5.0 ) ) / 2.0 )");
        StdOut.println(result02);
        double result03 = ArithmeticalExpression.evaluate("(1+((2+3)*(4*5)))");
        StdOut.println(result03);
        double result04 = ArithmeticalExpression.evaluate("((1+sqrt(5.0))/2.0)");
        StdOut.println(result04);
    }

    @org.junit.Test
    public void testBag() {
        CBag<String> bag = new CBag<>();
        String str = "to be or not to - be - - that - - - is";
        String[] strs = str.trim().split(" ");
        for (String s : strs) {
            if (!s.equals("-"))
                bag.add(s);
        }
        StdOut.println("The size of this CBag is " + bag.size());
        for (String s : bag) {
            StdOut.print(s + " ");
        }
    }

    @org.junit.Test
    public void testQueue() {
        CArrayQueue<String> queue = new CArrayQueue<>();
        String str = "to be or not to - be - - that - - - is";
        String[] strs = str.trim().split(" ");
        for (String s : strs) {
            if (!s.equals("-"))
                queue.push(s);
            else
                StdOut.print(queue.pop() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
    }

    @org.junit.Test
    public void testStack() {
        CArrayStack<String> stack = new CArrayStack<>();
        String str = "to be or not to - be - - that - - - is";
        String[] strs = str.trim().split(" ");
        for (String s : strs) {
            if (!s.equals("-"))
                stack.push(s);
            else
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on queue)");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
    }

    @org.junit.Test
    public void testLinkedStack() {
        CLinkedStack<String> stack = new CLinkedStack<>();
        String str = "to be or not to - be - - that - - - is";
        String[] strs = str.trim().split(" ");
        for (String s : strs) {
            if (!s.equals("-"))
                stack.push(s);
            else
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on queue)");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
    }

    @org.junit.Test
    public void testLinkedQueue() {
        CQueue<String> queue = new CLinkedQueue<>();
        String str = "to be or not to - be - - that - - - is";
        String[] strs = str.trim().split(" ");
        for (String s : strs) {
            if (!s.equals("-"))
                queue.push(s);
            else
                StdOut.print(queue.pop() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
    }

    @org.junit.Test
    public void testBubble() {
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.setPenRadius(0.01);
        StdDraw.circle(0.5, 0.5, 0.49);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledCircle(0.5, 0.5, 0.485);
        double x = 0.5, y = 0.5;
        double ang = StdRandom.uniform(-Math.PI, Math.PI);
        double speed = 0.002;
        while (true) {
            StdDraw.setPenRadius(0.008);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            if (StdDraw.isMousePressed()) {
                double xVal = StdDraw.mouseX(), yVal = StdDraw.mouseY();
                if (xVal < x && yVal < y)
                    ang = Math.atan((StdDraw.mouseY() - y) / (StdDraw.mouseX() - x)) + Math.PI;
                else if (xVal < x && yVal > y)
                    ang = Math.atan((StdDraw.mouseY() - y) / (StdDraw.mouseX() - x)) - Math.PI;
                else
                    ang = Math.atan((StdDraw.mouseY() - y) / (StdDraw.mouseX() - x));
                StdOut.println(ang);
            }
            StdDraw.filledCircle(x, y, 0.105);
            StdDraw.filledEllipse(x - 0.015, y + 0.08, 0.02, 0.01);
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledCircle(x + speed * Math.cos(ang), y + speed * Math.sin(ang), 0.1);
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledEllipse(x + speed * Math.cos(ang) - 0.015, y + speed * Math.sin(ang) + 0.08, 0.02, 0.01);
            StdDraw.setPenColor(120, 60, 100);
            StdDraw.circle(0.5, 0.5, 0.22);
            /*for (int i = 0; i < 12; i++) {
                double cos = Math.cos(i * Math.PI / 6);
                double sin = Math.sin(i * Math.PI / 6);
                StdDraw.line(0.5 + 0.22 * cos, 0.5 + 0.22 * sin, 0.5 + 0.485 * cos, 0.5 + 0.485 * sin);
            }*/
            StdDraw.pause(100);
            x = x + speed * Math.cos(ang);
            y = y + speed * Math.sin(ang);
            if ((x - 0.5) * (x - 0.5) + (y - 0.5) * (y - 0.5) >= 0.1425) {
                ang = StdRandom.uniform(ang + Math.PI * 2 / 3, ang + Math.PI * 4 / 3);
                while (ang > Math.PI)
                    ang -= Math.PI * 2;
                while (ang < Math.PI)
                    ang += Math.PI * 2;
            }
        }
        //StdDraw.pause(100000);
    }

    @org.junit.Test
    public void testBubble02() {
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.setPenRadius(0.01);
        StdDraw.circle(0.5, 0.5, 0.44);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledCircle(0.5, 0.5, 0.437);
        double x = 0.5, y = 0.5;
        double ang = 0;
        double speed = 0.008;
        while (true) {
            StdDraw.setPenRadius(0.008);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            double xVal = StdDraw.mouseX(), yVal = StdDraw.mouseY();
            if (xVal < x && yVal < y)
                ang = Math.atan((yVal - y) / (xVal - x)) - Math.PI;
            else if (xVal < x && yVal > y)
                ang = Math.atan((yVal - y) / (xVal - x)) + Math.PI;
            else
                ang = Math.atan((yVal - y) / (xVal - x));
            //StdOut.println(ang);
            StdOut.println("x:" + xVal + "y" + yVal + "x1:" + x + "y1:" + y);
            StdDraw.filledCircle(x, y, 0.105);
            StdDraw.filledEllipse(x - 0.072 * Math.cos(ang) + speed * Math.cos(ang), y - 0.072 * Math.sin(ang) + speed * Math.sin(ang),
                    0.01 + 0.016 * CMath.abs(Math.sin(ang)), 0.026 - 0.016 * CMath.abs(Math.sin(ang)));
            double t = 0.6;
            //StdDraw.circle(x - 0.07 * Math.cos(ang + t) + speed * Math.cos(ang), y - 0.07 * Math.sin(ang + t) + speed * Math.sin(ang), 0.01);
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            while ((x - 0.5) * (x - 0.5) + (y - 0.5) * (y - 0.5) >= 0.104) {
                double sx = Math.sqrt(0.323 * 0.323 * (xVal - 0.5) * (xVal - 0.5) / ((xVal - 0.5) * (xVal - 0.5) + (yVal - 0.5) * (yVal - 0.5)));
                double sy = Math.sqrt(0.323 * 0.323 * (yVal - 0.5) * (yVal - 0.5) / ((xVal - 0.5) * (xVal - 0.5) + (yVal - 0.5) * (yVal - 0.5)));
                if (xVal < 0.5) {
                    x = 0.5 - sx;
                } else {
                    x = 0.5 + sx;
                }
                if (yVal < 0.5){
                    y = 0.5 - sy;
                } else {
                    y = 0.5 + sy;
                }
            }
            StdDraw.filledCircle(x + speed * Math.cos(ang), y + speed * Math.sin(ang), 0.1);
            StdDraw.setPenColor(StdDraw.WHITE);
            //StdDraw.filledEllipse(x + speed * Math.cos(ang) - 0.015, y + speed * Math.sin(ang) + 0.08, 0.02, 0.01);

            StdDraw.filledEllipse(x - 0.072 * Math.cos(ang) + speed * Math.cos(ang), y - 0.072 * Math.sin(ang) + speed * Math.sin(ang),
                    0.01 + 0.016 * CMath.abs(Math.sin(ang)), 0.026 - 0.016 * CMath.abs(Math.sin(ang)));
            StdDraw.filledCircle(x - 0.075 * Math.cos(ang + t) + speed * Math.cos(ang), y - 0.075 * Math.sin(ang + t) + speed * Math.sin(ang),
                    0.01);

            StdDraw.setPenColor(120, 60, 100);
            StdDraw.circle(0.5, 0.5, 0.22);
            /*for (int i = 0; i < 12; i++) {
                double cos = Math.cos(i * Math.PI / 6);
                double sin = Math.sin(i * Math.PI / 6);
                StdDraw.line(0.5 + 0.22 * cos, 0.5 + 0.22 * sin, 0.5 + 0.485 * cos, 0.5 + 0.485 * sin);
            }*/
            StdDraw.pause(50);
            x = x + speed * Math.cos(ang);
            y = y + speed * Math.sin(ang);
        }
        //StdDraw.pause(100000);
    }

    @org.junit.Test
    public void testTanYiTan() {
        double x = 0.5, y = 1.0;
        while (true) {
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.setPenRadius(0.004);
            StdDraw.line(0.5, 1.0, x, y);
            x = StdDraw.mouseX();
            y = StdDraw.mouseY();
            StdDraw.setPenRadius(0.001);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(0.5, 1.0, x, y);
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.filledCircle(0.2, 0.2, 0.05);
            StdDraw.setPenColor(StdDraw.BLACK);
            if (StdDraw.isMousePressed()) {
                double xVal = 0.5, yVal = 1.0;
                double xS = StdDraw.mouseX(), yS = StdDraw.mouseY();
                double speed = 0.005;
                double ang = 0;
                if (xS < 0.5)
                    ang = Math.atan((StdDraw.mouseY() - 1.0) / (StdDraw.mouseX() - 0.5)) + Math.PI;
                else
                    ang = Math.atan((StdDraw.mouseY() - 1.0) / (StdDraw.mouseX() - 0.5));
                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                while (!(xVal < 0 || yVal < 0 || xVal > 1 || yVal > 1)) {
                    StdDraw.filledCircle(xVal + speed * Math.cos(ang), yVal + speed * Math.sin(ang), 0.05);
                    xVal = xVal + speed * Math.cos(ang);
                    yVal = yVal + speed * Math.sin(ang);
                }
            }
            StdDraw.pause(50);
        }
    }

    public static void main(String[] args) {
        //加载dom树
        Document doc = null;
        try {
            doc = new SAXReader().read("E:/IDEAworkspace/CAlgorithms for JAVA/srcdata.xml");
            //获取节点
            //List<Element> list = doc.selectNodes("/web-app/servlet/servlet-name");
            //Element ele = list.get(0);
            Element ele = (Element) doc.selectSingleNode("//compress-cmd/rar/url");
            System.out.println(ele.getText());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test7() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(CInteger.toBinaryString(-1));
    }
}
