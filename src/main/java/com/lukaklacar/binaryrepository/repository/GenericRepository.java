package com.lukaklacar.binaryrepository.repository;

import com.lukaklacar.binaryrepository.model.AbstractModel;
import com.lukaklacar.binaryrepository.query.Query;
import com.lukaklacar.binaryrepository.settings.BinaryRepositorySettings;

import java.io.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GenericRepository<T extends AbstractModel> {

    private Class<T> clazz;

    private BinaryRepositorySettings settings;

    public GenericRepository(Class<T> clazz, BinaryRepositorySettings settings) {
        this.clazz = clazz;
        this.settings = settings;
        ensureValidDataFileExists();
    }

    public List<T> all() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getDataLocation()));
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new CopyOnWriteArrayList<T>();
    }

    public void add(T model) {
        List<T> all = all();
        all.add(model);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getDataLocation()));
            oos.writeObject(all);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<T> find(Query<T> query) {
        CopyOnWriteArrayList<T> result = new CopyOnWriteArrayList<T>();

        for (T model : all()) {
            if (query.isValid(model)) {
                result.add(model);
            }
        }

        return result;
    }


    private void ensureValidDataFileExists() {
        File f = new File(getDataLocation());

        if (!f.exists()) {
            try {
                boolean result = f.createNewFile();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(new CopyOnWriteArrayList<T>());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getDataLocation() {
        return settings.getDataLocation() + "/" + clazz.getCanonicalName() + ".dat";
    }
}
