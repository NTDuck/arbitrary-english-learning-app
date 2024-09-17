package org.tomfoolery.core.usecases;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.tomfoolery.core.domain.DictionaryEntry;
import org.tomfoolery.core.repositories.DictionaryEntryRepository;

@RequiredArgsConstructor(staticName = "of")
public class UpdateDictionaryEntryUseCase {
    @NonNull
    private final DictionaryEntryRepository dictionaryEntryRepository;

    public void invoke(DictionaryEntry dictionaryEntry) throws DictionaryEntryRepository.NotFoundException {
        if (!this.dictionaryEntryRepository.contains(dictionaryEntry.getHeadword()))
            throw new DictionaryEntryRepository.NotFoundException();

        this.dictionaryEntryRepository.save(dictionaryEntry);
    }
}
