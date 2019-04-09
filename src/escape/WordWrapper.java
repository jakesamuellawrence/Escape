package escape;

public class WordWrapper {
    private static String wordWrap(String text, int width, String delim) {
        String out = "";
        String[] words;
        int currentWidth = 0;

        //Parse out tabs and new lines
        text = text.replaceAll("[\t\n]", " ");
        words = text.split(delim);

        //Rewrap to new width
        for (String word : words) {
            if (word.length() >= width) {
                //If it's not the first word, put it on a new line
                if (!out.isEmpty()) {
                    out += "\n";
                }
                out += word + " ";
                currentWidth = word.length();
            }
            else if ((currentWidth + word.length()) <= width) {
                out += word + " ";
                currentWidth += word.length() + 1;
            } else {
                out = out.substring(0, out.length() - 1);
                out += "\n" + word + " ";
                currentWidth = word.length() + 1;
            }
        }

        return out.substring(0, out.length() - 1);
    }

    public static String wordWrap(String text, int width) {
        return wordWrap(text, width, " ");
    }

    public static String drawBox(String text, int width) {
        String out;
        String border;
        String[] lines;

        border = " ";
        for (int i = 0; i < (width - 2); i++) {
            border += "-";
        }
        border += " \n";

        out = border;

        if (width < 5) {
            width = 5;
        }
        width -= 4;
        lines = wordWrap(text, width).split("\n");
        for (String line : lines) {
            out += String.format("| %-" + width + "s |\n", line);
        }

        out += border;

        return out;
    }

    public static String drawBoxes(String[] messages, int width) {
        String out = "";
        String[] boxes = new String[messages.length];
        String[][] lines;   //String[box's full string][array of box's string split at new line]
        int maxBoxLines = 0;

        if (messages.length == 1) {
            out = drawBox(messages[0], width);
        }
        else {
            width = width / messages.length - 1;

            for (int i = 0; i < messages.length; i++) {
                boxes[i] = drawBox(messages[i], width);
            }

            for (String box : boxes) {
                int boxLines = box.split("\n").length;
                if (boxLines > maxBoxLines) {
                    maxBoxLines = boxLines;
                }
            }
            lines = new String[boxes.length][maxBoxLines];

            for (int b = 0; b < boxes.length; b++) {
                lines[b] = boxes[b].split("\n");
            }

            for (int l = 0; l < maxBoxLines; l++) {
                String currentLine = "";
                for (int b = 0; b < boxes.length; b++) {
                    if (l >= lines[b].length) {
                        currentLine += String.format("%" + width + "s ", "");
                    }
                    else {
                        currentLine += lines[b][l] + " ";
                    }
                }
                out += currentLine.substring(0, currentLine.length() - 1) + "\n";
            }
        }

        return out;
    }

    public static String drawBoxes(String[] messages, int width, int boxesWide) {
        String out = "";

        if (messages.length <= boxesWide) {
            out = WordWrapper.drawBoxes(messages, width);
        }
        else {
            int currentBox = 0;
            String[] currentMessages;

            while (currentBox < messages.length) {
                if (boxesWide > messages.length - currentBox) {
                    boxesWide = messages.length - currentBox;
                }

                currentMessages = new String[boxesWide];

                for (int i = 0; i < boxesWide; i++) {
                    currentMessages[i] = messages[currentBox];
                    currentBox++;
                }

                out += WordWrapper.drawBoxes(currentMessages, width) + "\n";
            }
        }

        return out.substring(0, out.length() - 1);
    }
}
