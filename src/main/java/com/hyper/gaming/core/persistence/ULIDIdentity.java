package com.hyper.gaming.core.persistence;

import com.github.f4b6a3.ulid.UlidCreator;

import java.io.Serializable;
import java.util.Objects;

public abstract class ULIDIdentity implements Serializable {
  protected String ulid;

  public ULIDIdentity(String ulid) {
    this.ulid = ulid;
  }

  public ULIDIdentity() {
  }

  // Getters and Setters
  public String getULID() {
    return ulid;
  }

  public void setULID(String ulid) {
    this.ulid = ulid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ULIDIdentity that = (ULIDIdentity) o;

    return Objects.equals(ulid, that.ulid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ulid);
  }

  public static <T extends ULIDIdentity> T generate(Class<T> clazz) {
    try {
      return clazz.getConstructor(String.class).newInstance(UlidCreator.getUlid().toString());
    } catch (Exception e) {
      throw new RuntimeException("Error generating ULIDIdentity", e);
    }
  }
}

