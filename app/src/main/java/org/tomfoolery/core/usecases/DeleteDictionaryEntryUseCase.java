package org.tomfoolery.core.usecases;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.tomfoolery.core.repositories.DictionaryEntryRepository;


@RequiredArgsConstructor(staticName = "of")
public class DeleteDictionaryEntryUseCase {
    @NonNull
    private final DictionaryEntryRepository dictionaryEntryRepository;

    public void invoke(@NonNull String headword) {
        this.dictionaryEntryRepository.delete(headword);
    }
}
