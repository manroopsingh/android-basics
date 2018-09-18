package com.example.user.android_ndk;

public class MeshData {

    private int _facetCount;

    private float[] VertexCoords;

    MeshData(int facetCount)
    {
        _facetCount = facetCount;

        VertexCoords = new float[facetCount];

        // fills up coords with dummy values
        for(int i=0; i<facetCount; ++i)
        {
            VertexCoords[i] = 10.0f * i;
        }
    }

    public int getFacetCount()
    {
        return _facetCount;
    }
}
