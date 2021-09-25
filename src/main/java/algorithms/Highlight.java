package algorithms;

public interface Highlight {

    static Highlight of(int index, String color) {
        return new Highlight() {
            @Override
            public int index() {
                return index;
            }

            @Override
            public String color() {
                return color;
            }
        };
    }

    /**
     * The list index number of the item we are interested at highlighting.
     */
    int index();

    /**
     * Hex Code format of the color we want for this highlight.
     */
    String color();
}
