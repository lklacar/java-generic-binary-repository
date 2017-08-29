package com.lukaklacar.binaryrepository.query;

import com.lukaklacar.binaryrepository.model.AbstractModel;

public interface Query<T extends AbstractModel> {

    boolean isValid(T model);
}
