package org.tomfoolery.core.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.Value;

import javax.annotation.Nullable;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Data(staticConstructor = "of")
public class Document {
    private final @NonNull ID id;

    private final @NonNull Metadata metadata;
    private final @NonNull Audit audit;

    @Value(staticConstructor = "of")
    public static class ID {
        @NonNull String value;
    }

    @Data(staticConstructor = "of")
    public static class Metadata {
        private @NonNull String title;
        private @NonNull String description;
        private @NonNull List<String> authors = new ArrayList<>();

        private transient @NonNull BufferedImage qrCode;
    }

    @Data(staticConstructor = "of")
    public static class Audit {
        private final @NonNull Staff.ID createdByStaffId;
        private @Nullable Staff.ID lastModifiedByStaffId = null;

        private final @NonNull Collection<Patron.ID> borrowingPatronIds = new HashSet<>();

        private final @NonNull Timestamps timestamps = Timestamps.of();

        @Data(staticConstructor = "of")
        public static class Timestamps {
            private final @NonNull LocalDateTime created = LocalDateTime.now();
            private @Nullable LocalDateTime lastModified = null;
        }
    }
}
