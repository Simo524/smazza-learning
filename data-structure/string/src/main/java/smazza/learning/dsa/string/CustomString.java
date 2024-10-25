package smazza.learning.dsa.string;

import java.util.Arrays;

public class CustomString {

    private char[] value;

    public CustomString(char[] string) {
        this.value = Arrays.copyOf(string, string.length);
    }

    public CustomString(CustomString string) {
        this.value = Arrays.copyOf(string.getCharacters(), string.length());
    }

    public char[] getCharacters() {
        return Arrays.copyOf(value, length());
    }

    private Integer lastIndex() {
        return length()-1;
    }

    public Integer length() {
        return value.length;
    }

    public Integer indexOf(Character c) {
        for(int i=0 ; i < length() ; i++)
            if(value[i] == c)
                return i;

        return -1;
    }

    public Integer indexOf(Character c, Integer fromIndex) throws StringIndexOutOfBoundsException {
        if(fromIndex < 0 || fromIndex > lastIndex())
            throw new StringIndexOutOfBoundsException();

        for(int i=fromIndex ; i < length() ; i++)
            if(value[i] == c)
                return i;

        return -1;
    }

    public Integer lastIndexOf(Character c) {
        for(int i=lastIndex() ; i >= 0 ; i--)
            if(value[i] == c)
                return i;

        return -1;
    }

    public Integer lastIndexOf(Character c, Integer fromIndex) {
        if(fromIndex < 0 || fromIndex > lastIndex())
            throw new StringIndexOutOfBoundsException();

        for(int i=fromIndex ; i >= 0 ; i--)
            if(value[i] == c)
                return i;

        return -1;
    }

    public Boolean contains(Character c) {
        return indexOf(c) >= 0;
    }

    public Boolean contains(char[] string) {
        Integer result;

        for(int i=0 ; i < length() ; i++) {
            result = 0;

            if (string[0] == value[i]) {
                for (int j = 1; j < string.length; j++)
                    if (string[j] == value[i + j])
                        result++;

                if(result == string.length-1)
                    return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;
    }

    public Boolean contains(CustomString string) {
        return contains(string.getCharacters());
    }

    public Boolean isEmpty() {
        return length() == 0;
    }

    public Boolean isNotEmpty() {
        return !isEmpty();
    }

    public Boolean isBlank() {
        return value == null || length() == 0;
    }

    public Boolean isNotBlank() {
        return !isBlank();
    }

    public Boolean equals(char[] string) {
        if(string.length != length() || length() == 0)
            return Boolean.FALSE;

        for(int i=0 ; i < length() ; i++)
            if(value[i] != string[i])
                return Boolean.FALSE;

        return Boolean.TRUE;
    }

    public Boolean equals(CustomString string) {
        return equals(string.getCharacters());
    }

    public Boolean equalsIgnoreCase(char[] string) {
        char[] valueLowerCase = toLowerCase().getCharacters();
        char[] stringLowerCase = new CustomString(string).toLowerCase().getCharacters();

        if(string.length != length() || length() == 0)
            return Boolean.FALSE;

        for(int i=0 ; i < length() ; i++)
            if(valueLowerCase[i] != stringLowerCase[i])
                return Boolean.FALSE;

        return Boolean.TRUE;
    }

    public Boolean equalsIgnoreCase(CustomString string) {
        return equalsIgnoreCase(string.getCharacters());
    }

    public Boolean endsWith(Character c) throws StringIndexOutOfBoundsException {
        if(length() == 0)
            throw new StringIndexOutOfBoundsException();

        return value[lastIndex()] == c;
    }

    public Boolean endsWith(char[] string) throws StringIndexOutOfBoundsException {
        if(string.length > length())
            throw new StringIndexOutOfBoundsException();

        for(int i=length()-string.length, j=0 ; i < length() ; i++, j++)
            if(value[i] != string[j])
                return Boolean.FALSE;

        return Boolean.TRUE;
    }

    public Boolean endsWith(CustomString string) throws StringIndexOutOfBoundsException {
        return endsWith(string.getCharacters());
    }

    public Boolean startsWith(Character c) throws StringIndexOutOfBoundsException {
        if(length() == 0)
            throw new StringIndexOutOfBoundsException();

        return value[0] == c;
    }

    public Boolean startsWith(char[] string) throws StringIndexOutOfBoundsException {
        if(string.length > length())
            throw new StringIndexOutOfBoundsException();

        for(int i=0 ; i < string.length ; i++)
            if(value[i] != string[i])
                return Boolean.FALSE;

        return Boolean.TRUE;
    }

    public Boolean startsWith(CustomString string) throws StringIndexOutOfBoundsException {
        return startsWith(string.getCharacters());
    }

    public Character charAt(Integer index) throws StringIndexOutOfBoundsException {
        if(index < 0 || index > lastIndex())
            throw new StringIndexOutOfBoundsException();

        return value[index];
    }

    public CustomString toLowerCase() {
        char[] toLowerCase = Arrays.copyOf(value, length());

        for(int i=0 ; i < length() ; i++)
            if(Character.isUpperCase(toLowerCase[i]))
                toLowerCase[i] = Character.toLowerCase(toLowerCase[i]);

        return new CustomString(toLowerCase);
    }

    public CustomString toUpperCase() {
        char[] toUpperCase = Arrays.copyOf(value, length());

        for(int i=0 ; i < length() ; i++)
            if(Character.isLowerCase(toUpperCase[i]))
                toUpperCase[i] = Character.toUpperCase(toUpperCase[i]);

        return new CustomString(toUpperCase);
    }

    public CustomString replace(Character oldChar, Character newChar) {
        char[] replaced = Arrays.copyOf(value, length());

        for(int i=0 ; i < length() ; i++)
            if(replaced[i] == oldChar) {
                replaced[i] = newChar;
                return new CustomString(replaced);
            }

        return this;
    }

    public CustomString replace(Character oldChar, Character newChar, Integer fromIndex) throws StringIndexOutOfBoundsException {
        if(fromIndex < 0 || fromIndex > lastIndex())
            throw new StringIndexOutOfBoundsException();

        char[] replaced = Arrays.copyOf(value, length());

        for(int i=fromIndex ; i < length() ; i++)
            if(replaced[i] == oldChar) {
                replaced[i] = newChar;
                return new CustomString(replaced);
            }

        return this;
    }

    public CustomString replace(Character oldChar, Character newChar, Integer fromIndex, Integer toIndex) throws StringIndexOutOfBoundsException, IllegalArgumentException {
        if(fromIndex < 0 || toIndex < 0 || fromIndex > lastIndex() || toIndex > lastIndex())
            throw new StringIndexOutOfBoundsException();

        if(fromIndex >= toIndex)
            throw new IllegalArgumentException();

        char[] replaced = Arrays.copyOf(value, length());

        for(int i=fromIndex ; i < toIndex ; i++)
            if(replaced[i] == oldChar) {
                replaced[i] = newChar;
                return new CustomString(replaced);
            }

        return this;

    }

    public CustomString replaceAll(Character oldChar, Character newChar) {
        char[] replaced = Arrays.copyOf(value, length());

        for(int i=0 ; i < length() ; i++)
            if(replaced[i] == oldChar)
                replaced[i] = newChar;

        return new CustomString(replaced);

    }

    public CustomString replaceAll(Character oldChar, Character newChar, Integer fromIndex) throws StringIndexOutOfBoundsException {
        if(fromIndex < 0 || fromIndex > lastIndex())
            throw new StringIndexOutOfBoundsException();

        char[] replaced = Arrays.copyOf(value, length());

        for(int i=fromIndex ; i < length() ; i++)
            if(replaced[i] == oldChar)
                replaced[i] = newChar;

        return new CustomString(replaced);
    }

    public CustomString replaceAll(Character oldChar, Character newChar, Integer fromIndex, Integer toIndex) throws StringIndexOutOfBoundsException, IllegalArgumentException {
        if(fromIndex < 0 || toIndex < 0 || fromIndex > lastIndex() || toIndex > lastIndex())
            throw new StringIndexOutOfBoundsException();

        if(fromIndex >= toIndex)
            throw new IllegalArgumentException();

        char[] replaced = Arrays.copyOf(value, length());

        for(int i=fromIndex ; i < toIndex ; i++)
            if(replaced[i] == oldChar)
                replaced[i] = newChar;

        return new CustomString(replaced);
    }

    public CustomString substring(Integer fromIndex) throws StringIndexOutOfBoundsException {
        if(fromIndex < 0 || fromIndex > lastIndex())
            throw new StringIndexOutOfBoundsException();

        char[] substring = new char[length()-fromIndex];
        for(int i=fromIndex, j=0 ; i < length() ; i++, j++)
            substring[j] = value[i];

        return new CustomString(substring);
    }

    public CustomString substring(Integer fromIndex, Integer toIndex) throws StringIndexOutOfBoundsException, IllegalArgumentException {
        if(fromIndex < 0 || toIndex < 0 || fromIndex > lastIndex() || toIndex > lastIndex())
            throw new StringIndexOutOfBoundsException();

        if(fromIndex >= toIndex)
            throw new IllegalArgumentException();

        char[] substring = new char[toIndex-fromIndex];
        for(int i=fromIndex, j=0 ; i < toIndex ; i++, j++)
            substring[j] = value[i];

        return new CustomString(substring);
    }

    public CustomString concat(Character c) {
        char[] concatenated = Arrays.copyOf(value, length()+1);
        concatenated[length()] = c;

        return new CustomString(concatenated);
    }

    public CustomString concat(char[] string) {
        char[] concatenated = Arrays.copyOf(value, length()+string.length);

        for(int i=0, j=length() ; i < string.length ; i++, j++)
            concatenated[j] = string[i];

        return new CustomString(concatenated);
    }

    public CustomString concat(CustomString string) {
        return concat(string.getCharacters());
    }

    public String toString() {
        return new String(value);
    }

}
