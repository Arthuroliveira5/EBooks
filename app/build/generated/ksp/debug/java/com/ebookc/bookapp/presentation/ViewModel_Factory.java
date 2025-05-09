package com.ebookc.bookapp.presentation;

import com.ebookc.bookapp.domain.repo.AllBookRepo;
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
public final class ViewModel_Factory implements Factory<ViewModel> {
  private final Provider<AllBookRepo> repoProvider;

  public ViewModel_Factory(Provider<AllBookRepo> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public ViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static ViewModel_Factory create(Provider<AllBookRepo> repoProvider) {
    return new ViewModel_Factory(repoProvider);
  }

  public static ViewModel newInstance(AllBookRepo repo) {
    return new ViewModel(repo);
  }
}
