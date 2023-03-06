package PoolGame.config;

/** Factory Class for building readers. */
public class TableReaderFactory implements ReaderFactory {
    /**
     * Builds a TableReader.
     * 
     * @return table reader.
     */
    public Reader buildReader() {
        return new TableReader();
    };
}