package ru.kpfu.formsvalidation.captcha;

import ru.kpfu.formsvalidation.captcha.RandomCharacterGenerator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class CaptchaGenerator {

    private Integer characterSize;

    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;

    private Integer width;
    private final Integer HEIGHT = 70;

    private RandomCharacterGenerator characterGenerator;
    private Random random;

    private String[] characters;

    private ByteArrayOutputStream os;

    private Color textColor = Color.BLACK;
    private Color backgroundColor = Color.WHITE;

    public CaptchaGenerator(Integer characterSize) {
        this.setCharacterSize(characterSize);

        this.bufferedImage = new BufferedImage(width, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        graphics2D = bufferedImage.createGraphics();

        characterGenerator = new RandomCharacterGenerator();
        random = characterGenerator.getRandom();
    }

    public void drawRandomCharacters() {
        reset();
        characters = characterGenerator.generateCharacters(characterSize);
        graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 48));

        for (int i = 0; i < characterSize; i++) {
            int x = ((i + 1) * random(48, 5)), y = 48 + random(5, 2), angle = random(0, 42);

            angle = (random(0, 2) == 0)  ? angle : angle * -1;

            graphics2D.translate((float)x,(float)y);
            graphics2D.rotate(Math.toRadians(angle));
            graphics2D.drawString(characters[i],  0, 0);
            graphics2D.rotate(-Math.toRadians(angle));
            graphics2D.translate(-(float)x,-(float)y);
        }
    }

    public void save() {
        try {
            os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", os);
            //reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getImage() {
        return os.toByteArray();
    }

    private void reset() {
        graphics2D.setColor(backgroundColor);
        graphics2D.fillRect(0, 0, width, HEIGHT);
        graphics2D.setColor(textColor);
    }

    private int random(int max, int min) {
        return random.nextInt(min) + max;
    }

    public void setCharacterSize(Integer characterSize) {
        this.characterSize = characterSize;
        width = characterSize * 70;
    }
}
