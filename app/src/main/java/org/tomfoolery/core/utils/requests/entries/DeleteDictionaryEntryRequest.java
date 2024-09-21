package org.tomfoolery.core.utils.requests.entries;

import lombok.NonNull;
import lombok.Value;
import org.tomfoolery.core.domain.DictionaryEntry;

@Value(staticConstructor = "of")
public class DeleteDictionaryEntryRequest {
    @NonNull DictionaryEntry.ID dictionaryEntryID;
}
