<script>
    import RangeSlider from "svelte-range-slider-pips";

    let character;

    let selected = { id: 0, text: " " };

    let speedSliderValue;
    let speedSliderStats;
    let mightSliderValue;
    let mightSliderStats;
    let sanitySliderValue;
    let sanitySliderStats;
    let knowledgeSliderValue;
    let knowledgeSliderStats;

    let characters = [
        { id: 1, text: `Father Rhinehardt` },
        { id: 2, text: `Professor Longfellow` },
        { id: 3, text: `Peter Akimoto` },
        { id: 4, text: `Brandon Jaspers` },
        { id: 5, text: `Jenny LeClerc` },
        { id: 6, text: `Heather Granville` },
        { id: 7, text: `Vivian Lopez` },
        { id: 8, text: `Madame Zostra` },
        { id: 9, text: `Darrin "Flash" Williams` },
        { id: 10, text: `Ox Bellows` },
        { id: 11, text: `Zoe Ingstrom` },
        { id: 12, text: `Miss Dubourde` },
    ];

    async function updateCharacterInfo(e) {
        const response = await fetch(
            `http://localhost:8090/betrayal/api/character?id=${selected.id}`
        );

        if (response.ok) {
            const received = await response.json();
            console.log(received);
            character = received;
            speedSliderValue = character.defaultSpIndex;
            speedSliderStats = [...character.speedStats];
            speedSliderStats.unshift("💀");
            mightSliderValue = character.defaultMiIndex;
            mightSliderStats = [...character.mightStats];
            mightSliderStats.unshift("💀");
            sanitySliderValue = character.defaultSaIndex;
            sanitySliderStats = [...character.sanityStats];
            sanitySliderStats.unshift("💀");
            knowledgeSliderValue = character.defaultKnIndex;
            knowledgeSliderStats = [...character.knowledgeStats];
            knowledgeSliderStats.unshift("💀");
        }

        if (localStorage.getItem(selected.id)) {
        }
    }
</script>

<main>
    <h1>Betrayal Stat Tracker</h1>
    <h2>Character:</h2>
    <select bind:value={selected} on:change={(e) => updateCharacterInfo(e)}>
        {#each characters as selectedCharacter}
            <option value={selectedCharacter}>
                {selectedCharacter.text}
            </option>
        {/each}
    </select>

    {#if character}
        <p>
            {character.name}, age {character.age}, [Is dit een saved character?]
        </p>

        <p>Speed array: {character.speedStats}</p>
        <p class="statNames">Speed</p>
        <div class="speedSlider">
            <RangeSlider
                id="speed-slider"
                bind:values={speedSliderValue}
                formatter={(v) => speedSliderStats[v]}
                min={0}
                max={8}
                pips
                all="label"
            />
        </div>
        <p class="currentStats">
            Current speed: {speedSliderStats[speedSliderValue]}
        </p>
        <p>Default speed: {character.defaultSpIndex}</p>

        <p>Might array: {character.mightStats}</p>
        <p class="statNames">Might</p>
        <div class="mightSlider">
            <RangeSlider
                id="might-slider"
                bind:values={mightSliderValue}
                formatter={(v) => mightSliderStats[v]}
                min={0}
                max={8}
                pips
                all="label"
            />
        </div>
        <p class="currentStats">
            current Might: {mightSliderStats[mightSliderValue]}
        </p>
        <p>Default Might, nog kleuren: {character.defaultMiIndex}</p>

        <p>{character.sanityStats}</p>
        <p class="statNames">Sanity</p>
        <div class="sanitySlider">
            <RangeSlider
                id="sanity-slider"
                bind:values={sanitySliderValue}
                formatter={(v) => sanitySliderStats[v]}
                min={0}
                max={8}
                pips
                all="label"
            />
        </div>
        <p class="currentStats">
            current Sanity: {sanitySliderStats[sanitySliderValue]}
        </p>
        <p>Default Sanity, nog kleuren: {character.defaultSaIndex}</p>

        <p>{character.knowledgeStats}</p>
        <p class="statNames">Knowledge</p>
        <div class="knowledgeSlider">
            <RangeSlider
                id="knowledge-slider"
                bind:values={knowledgeSliderValue}
                formatter={(v) => knowledgeSliderStats[v]}
                min={0}
                max={8}
                pips
                all="label"
            />
        </div>
        <p class="currentStats">
            current Knowledge: {knowledgeSliderStats[knowledgeSliderValue]}
        </p>
        <p>Default Knowledge, nog kleuren: {character.defaultKnIndex}</p>
    {/if}
</main>

<style>
    main {
        text-align: center;
        padding: 1em;
        max-width: 240px;
        margin: 0 auto;
    }

    h1 {
        color: #832323;
        text-transform: uppercase;
        font-size: 4em;
        font-weight: 150;
    }

    @media (min-width: 640px) {
        main {
            max-width: none;
        }
    }
</style>
