
public class SimpleHashtable {
    private SavedPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public boolean isOccuppied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    public void put(String key, Player player) {
        int hashedKey = hashKey(key);
        if (isOccuppied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (hashedKey != stoppingIndex && isOccuppied(hashedKey)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccuppied(hashedKey)) {
            System.out.println("Value already exists at bucket " + hashedKey);
            return;
        }

        hashtable[hashedKey] = new SavedPlayer(key, player);
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        if (isOccuppied(hashedKey) && hashtable[hashedKey].getKey().equals(key))
            return hashedKey;

        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                isOccuppied(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (isOccuppied(hashedKey) && hashtable[hashedKey].getKey().equals(key))
            return hashedKey;

        return -1;
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
            return null;

        return hashtable[hashedKey].getPlayer();
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            Player player = null;

            if (isOccuppied(i))
                player = hashtable[i].getPlayer();

            System.out.println("Value at bucket " + i + " - " + player);
        }
    }

    public void remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            System.out.println("Key not found");
            return;
        }

        hashtable[hashedKey] = null;

        SavedPlayer[] oldHashtable = hashtable;
        hashtable = new SavedPlayer[10];

        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].getKey(), oldHashtable[i].getPlayer());
            }
        }
    }
}
