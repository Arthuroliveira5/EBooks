package com.ebookc.bookapp.data.RepoImpl;

import com.google.firebase.database.FirebaseDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AllBookRepoImpl_Factory implements Factory<AllBookRepoImpl> {
  private final Provider<FirebaseDatabase> firebaseDatabaseProvider;

  public AllBookRepoImpl_Factory(Provider<FirebaseDatabase> firebaseDatabaseProvider) {
    this.firebaseDatabaseProvider = firebaseDatabaseProvider;
  }

  @Override
  public AllBookRepoImpl get() {
    return newInstance(firebaseDatabaseProvider.get());
  }

  public static AllBookRepoImpl_Factory create(
      Provider<FirebaseDatabase> firebaseDatabaseProvider) {
    return new AllBookRepoImpl_Factory(firebaseDatabaseProvider);
  }

  public static AllBookRepoImpl newInstance(FirebaseDatabase firebaseDatabase) {
    return new AllBookRepoImpl(firebaseDatabase);
  }
}
