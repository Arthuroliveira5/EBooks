package com.ebookc.bookapp.data.di;

import com.ebookc.bookapp.domain.repo.AllBookRepo;
import com.google.firebase.database.FirebaseDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class HiltModule_ProvideAllBookRepoFactory implements Factory<AllBookRepo> {
  private final Provider<FirebaseDatabase> firebaseDatabaseProvider;

  public HiltModule_ProvideAllBookRepoFactory(Provider<FirebaseDatabase> firebaseDatabaseProvider) {
    this.firebaseDatabaseProvider = firebaseDatabaseProvider;
  }

  @Override
  public AllBookRepo get() {
    return provideAllBookRepo(firebaseDatabaseProvider.get());
  }

  public static HiltModule_ProvideAllBookRepoFactory create(
      Provider<FirebaseDatabase> firebaseDatabaseProvider) {
    return new HiltModule_ProvideAllBookRepoFactory(firebaseDatabaseProvider);
  }

  public static AllBookRepo provideAllBookRepo(FirebaseDatabase firebaseDatabase) {
    return Preconditions.checkNotNullFromProvides(HiltModule.INSTANCE.provideAllBookRepo(firebaseDatabase));
  }
}
