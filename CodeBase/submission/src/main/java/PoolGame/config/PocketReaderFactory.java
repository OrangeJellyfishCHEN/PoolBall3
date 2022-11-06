package PoolGame.config;

/** Factory Class for building Pocket readers. */
public class PocketReaderFactory implements ReaderFactory{
    /**
     * Builds a PocketReader.
     *
     * @return new PocketReader();
     */
    @Override
    public Reader buildReader() {
        return new PocketReader();
    }
}
