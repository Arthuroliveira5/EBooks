package com.ebookc.bookapp.data.di;

import com.google.firebase.database.FirebaseDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class HiltModule_ProvideRealtimeDatabaseFactory implements Factory<FirebaseDatabase> {
  @Override
  public FirebaseDatabase get() {
    return provideRealtimeDatabase();
  }

  public static HiltModule_ProvideRealtimeDatabaseFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FirebaseDatabase provideRealtimeDatabase() {
    return Preconditions.checkNotNullFromProvides(HiltModule.INSTANCE.provideRealtimeDatabase());
  }

  private static final class InstanceHolder {
    private static final HiltModule_ProvideRealtimeDatabaseFactory INSTANCE = new HiltModule_ProvideRealtimeDatabaseFactory();
  }
}
