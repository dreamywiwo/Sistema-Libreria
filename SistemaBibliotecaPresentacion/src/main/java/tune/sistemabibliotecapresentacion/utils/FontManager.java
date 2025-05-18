/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tune.sistemabibliotecapresentacion.utils;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public class FontManager {
    
    private Font afacadRegular;
    private Font afacadMedium;
    private Font afacadBold;

    public FontManager() {
        try {
            
            afacadRegular = loadFont("/fonts/Afacad-Regular.ttf");
            afacadMedium = loadFont("/fonts/Afacad-Medium.ttf");
            afacadBold = loadFont("/fonts/Afacad-Bold.ttf");
            
            registerFonts();
            
        } catch (Exception e) {
            e.printStackTrace();
            setFallbackFonts();
        }
    }
    
    private Font loadFont(String resourcePath) throws Exception {
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new Exception("Font resource not found: " + resourcePath);
            }
            return Font.createFont(Font.TRUETYPE_FONT, is);
        }
    }
    
    private void registerFonts() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(afacadRegular);
        ge.registerFont(afacadMedium);
        ge.registerFont(afacadBold);

    }
    
    private void setFallbackFonts() {
        afacadRegular = new Font("Afacad", Font.PLAIN, 12);
        afacadMedium = new Font("AfacadMedium", Font.PLAIN, 12);
        afacadBold = new Font("AfacadBold", Font.PLAIN, 12);

    }
    
    public Font getAfacadRegular(float size) {
        return afacadRegular != null ? afacadRegular.deriveFont(size) : new Font("SansSerif", Font.PLAIN, (int) size);
    }

    public Font getAfacadMedium(float size) {
        return afacadMedium != null ? afacadMedium.deriveFont(size) : new Font("SansSerif", Font.PLAIN, (int) size);
    }

    public Font getAfacadBold(float size) {
        return afacadBold != null ? afacadBold.deriveFont(size) : new Font("SansSerif", Font.BOLD, (int) size);
    }   
    
    public Font getFont(String fontFamily, String style, float size) {
        switch (fontFamily) {
            case "Afacad":
                return getAfacadRegular(size);
            case "Afacad Medium":
                return getAfacadMedium(size);
            case "Afacad Bold":
                return getAfacadBold(size);
            default:
                return new Font("SansSerif", Font.PLAIN, (int)size);
        }
    }
}
