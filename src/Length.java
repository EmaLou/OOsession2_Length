import java.util.HashMap;

public class Length {

    private String unit;
    private int length;
    private HashMap<String, Integer> unitList = new HashMap<String, Integer>();

    public Length(int length, String unit) {
        this.length = length;
        this.unit = unit;
        unitList.put("cm", 1);
        unitList.put("dm", 10);
    }

    public int transform(String unit) {
        return unitTransform(unit, transformToBaseUnit());
    }

    public int unitTransform(String resultUnit, int length) {
        return length / unitList.get(resultUnit);
    }

    public int transformToBaseUnit() {
        return this.length * unitList.get(this.unit);
    }

    public int add(Length length, String unit) {
        int unitLength = transformToBaseUnit() + length.transformToBaseUnit();
        return unitTransform(unit,unitLength);
    }

    public int minus(Length length, String unit) {
        int unitLength = transformToBaseUnit() - length.transformToBaseUnit();
        return unitTransform(unit,unitLength);
    }
}
