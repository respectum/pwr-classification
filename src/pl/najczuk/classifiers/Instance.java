package pl.najczuk.classifiers;

import java.util.ArrayList;

/**
 * User: Adrian
 * Date: 10/31/2014
 * Time: 21:42
 */
public class Instance {
    private ArrayList<Attribute> attributes;
    private ArrayList<Float> values;

    public Instance(ArrayList<Attribute> attributes, ArrayList<String> values) {
        this.attributes = attributes;
        this.values = getFloatValuesFromObjects(values);

    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<Float> getValues() {
        return values;
    }

    public void setValues(ArrayList<Float> values) {
        this.values = values;
    }



    private ArrayList<Float> getFloatValuesFromObjects(ArrayList<String> mixedValues) {
        ArrayList<Float> floatValues = new ArrayList<Float>();
        int limit = attributes.size();
        for (int currentAttributeIndex = 0; currentAttributeIndex < limit; currentAttributeIndex++) {
            extractFloatValueForAttribute(mixedValues, floatValues, currentAttributeIndex);
        }
        return floatValues;

    }

    private void extractFloatValueForAttribute(ArrayList<String> mixedValues, ArrayList<Float> floatValues,
                                               int currentAttributeIndex) {
        if (attributes.get(currentAttributeIndex).getType().equals(AttributeType.NUMERIC))
            floatValues.add(currentAttributeIndex, Float.valueOf(mixedValues.get(currentAttributeIndex)));
        else if (attributes.get(currentAttributeIndex).getType().equals(AttributeType.NOMINAL)) {
            floatValues.add(currentAttributeIndex, attributes.get(currentAttributeIndex).getNumericValue((
                     (mixedValues.get(currentAttributeIndex)))));
        } else {
            floatValues.add(currentAttributeIndex, null);
        }
    }

    @Override
    public String toString() {
        return "Instance{" +
                "attributes=" + attributes +
                ", values=" + values +
                '}';
    }
}
