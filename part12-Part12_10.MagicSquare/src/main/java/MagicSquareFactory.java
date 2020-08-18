
public class MagicSquareFactory {

    private int calculateAmountOfNumbersToPlace(int size) {
        return size * size;
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

    private int calculateCenterMostCell(int size) {
        return (int) (size / 2);
    }

    private boolean isPlaceFree(MagicSquare square, int x, int y) {
        return square.readValue(x, y) == 0;
    }

    private boolean isOutsideOfTheSquare(MagicSquare square, int x, int y) {
        return x < 0 || y < 0 || x >= square.getWidth() || y >= square.getHeight();
    }

    private int transformValue(MagicSquare square, int value) {
        if (value < 0) {
            value = square.getWidth() - 1;
        }
        if (value >= square.getWidth()) {
            value = 0;
        }

        return value;
    }

    public MagicSquare createMagicSquare(int size) {
        if (isOdd(size)) {
            MagicSquare square = new MagicSquare(size);
            int amountOfNumbersNeeded = calculateAmountOfNumbersToPlace(square.getWidth());
            int x = calculateCenterMostCell(square.getWidth() - 1);
            int y = 0;
            int amountOfPlacedNumbers = 1;
            square.placeValue(x, y, amountOfPlacedNumbers);
            while (amountOfPlacedNumbers++ < amountOfNumbersNeeded) {
                int upRightCalculatedX = x + 1;
                int upRightCalculatedY = y - 1;
                if (isOutsideOfTheSquare(square, upRightCalculatedX, upRightCalculatedY)) {
                    upRightCalculatedX = transformValue(square, upRightCalculatedX);
                    upRightCalculatedY = transformValue(square, upRightCalculatedY);
                }
                if (isPlaceFree(square, upRightCalculatedX, upRightCalculatedY)) {
                    square.placeValue(upRightCalculatedX, upRightCalculatedY, amountOfPlacedNumbers);
                    x = upRightCalculatedX;
                    y = upRightCalculatedY;
                } else {
                    int bottomCalculatedX = x;
                    int bottomCalculatedY = y + 1;
                    if (isOutsideOfTheSquare(square, bottomCalculatedX, bottomCalculatedY)) {
                        bottomCalculatedX = transformValue(square, bottomCalculatedX);
                        bottomCalculatedY = transformValue(square, bottomCalculatedY);
                    }
                    square.placeValue(bottomCalculatedX, bottomCalculatedY, amountOfPlacedNumbers);
                    x = bottomCalculatedX;
                    y = bottomCalculatedY;
                }
            }
            return square;
        }
        return null;
    }
}
