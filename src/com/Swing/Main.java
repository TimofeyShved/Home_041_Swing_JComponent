package com.Swing;

import javafx.geometry.Rectangle2D;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = getFrame(); // создаем класс, для запуска программы, из нашего класса
        jFrame.add(new MyComponent()); // добавляем компоненты на форму
    }

    static class MyComponent extends JComponent{
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g; // создаем класс, для создания и прорисовки на форме

            // создаем запись
            Font font = new Font("Arial", Font.BOLD, 20); // оформление текста
            g2.setFont(font); // передаем в него настройки текста
            g2.drawString("Hello world", 20, 20); // выводим текст Lable

            // создаем линию
            Line2D l1 = new Line2D.Double(20,20,70,70); // линия - \
            g2.draw(l1);
            Point2D p1 = new Point2D.Double(70,20); // создаем точку
            Point2D p2 = new Point2D.Double(20,70);
            Line2D l2 = new Line2D.Double(p1,p2); // линия - /
            g2.draw(l2);

            //создаем окружность
            Ellipse2D el = new Ellipse2D.Double(120,70,150,150);
            g2.setPaint(Color.RED); // даем красный цвет
            g2.fill(el); // полноценная заливка

            //создаем прямоугольник
            Rectangle re = new Rectangle();
            re.setFrameFromDiagonal(120,70,270,220);
            g2.draw(re);

            //вставка картинок
            try {

                //ссылка
                URL url = new URL("https://images.velog.io/images/rxjw95/post/f99be4df-8f51-4aad-9814-b6d38e3eebb8/intellij_logo.png");

                // записываем в Image
                Image image = new ImageIcon(url).getImage();

                // вывод картинки на экран
                g2.drawImage(image, 160, 20, 20, 20, null);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            //super.paintComponent(g);
        }
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};//наш класс, для запуска программы
        jFrame.setVisible(true);// делаем видимость
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// добавляем операцию для выхода
        Toolkit toolkit = Toolkit.getDefaultToolkit();// набор инструментов, с нашими JFrame
        Dimension dimension = toolkit.getScreenSize(); //возвращяет значения нашего экрана
        // размеры окна
        jFrame.setBounds(dimension.width/2 - 250, dimension.height/2 -150, 500, 300);
        jFrame.setTitle("Hello");// надпись Title
        //jFrame.setIconImage(путь);
        return jFrame;
    }
}
