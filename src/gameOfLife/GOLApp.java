package gameOfLife;
/* Ahhh the game of life... at least conway's game of life. Very simple cell properties that live, die or be born.
   Main properties come off of https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life, and GUI, OOP principles used
   in practice of university course. Thanks ;)

   To try it out, run GOLApp: Select cells or start randomized cells (warning epilepsy warning).

   @author Eric Leung
 */

public class GOLApp {
    public static void main(String[] args) {
        GUIFrame golgui = new GUIFrame();
        javax.swing.SwingUtilities.invokeLater(golgui);
    }
}
